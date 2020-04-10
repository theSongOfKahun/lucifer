package cn.kahun.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @create: 2019/12/12 2:33 下午
 * @author: kahun
 * @description:
 * From: https://github.com/twitter/snowflake An object that generates IDs.
 * This is broken into a separate class in case we ever want to support multiple worker threads per process
 **/
public class IdWorker {

  private static final Logger logger = LoggerFactory.getLogger(IdWorker.class);

  private long workerId;
  private long dataCenterId;
  private long sequence = 0L;

  private long workerIdBits = 5L;
  private long dataCenterIdBits = 5L;
  private long sequenceBits = 12L;

  private long workerIdShift = sequenceBits;
  private long dataCenterIdShift = sequenceBits + workerIdBits;
  private long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
  private long sequenceMask = ~(-1L << sequenceBits);

  private long lastTimestamp = -1L;

  public IdWorker(long workerId, long dataCenterId) {
    // sanity check for workerId
    long maxWorkerId = ~(-1L << workerIdBits);
    if (workerId > maxWorkerId || workerId < 0) {
      throw new IllegalArgumentException(
          String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
    }
    long maxDataCenterId = ~(-1L << dataCenterIdBits);
    if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
      throw new IllegalArgumentException(
          String.format("dataCenter Id can't be greater than %d or less than 0", maxDataCenterId));
    }
    this.workerId = workerId;
    this.dataCenterId = dataCenterId;
    logger.info(String.format(
        "worker starting. timestamp left shift %d, dataCenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
        timestampLeftShift, dataCenterIdBits, workerIdBits, sequenceBits, workerId));
  }

  public synchronized long nextId() {
    long timestamp = timeGen();

    if (timestamp < lastTimestamp) {
      logger.error(
          String.format("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp));
      throw new RuntimeException(
          String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
              lastTimestamp - timestamp));
    }

    if (lastTimestamp == timestamp) {
      sequence = (sequence + 1) & sequenceMask;
      if (sequence == 0) {
        timestamp = tilNextMillis(lastTimestamp);
      }
    } else {
      sequence = 0L;
    }

    lastTimestamp = timestamp;

    long twEpoch = 1288834974657L;
    return ((timestamp - twEpoch) << timestampLeftShift) | (dataCenterId << dataCenterIdShift)
        | (workerId << workerIdShift) | sequence;
  }

  protected long tilNextMillis(long lastTimestamp) {
    long timestamp = timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen();
    }
    return timestamp;
  }

  protected long timeGen() {
    return System.currentTimeMillis();
  }


}
