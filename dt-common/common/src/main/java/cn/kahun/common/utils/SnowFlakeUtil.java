package cn.kahun.common.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @create: 2019/12/12 2:31 下午
 * @author: liboah
 * @description: snow flake util
 **/
public class SnowFlakeUtil {

  private IdWorker provider;

  private Long dataCenterId;

  private Long workId;

  private static final Logger logger = LoggerFactory.getLogger(SnowFlakeUtil.class);

  private SnowFlakeUtil(IdWorker provider) {
    this.provider = provider;
  }

  private IdWorker getProvider(){

    if (provider == null){
      synchronized (SnowFlakeUtil.class){
        if (provider == null){
          init();
          provider = new IdWorker(dataCenterId,workId);
        }
      }
    }
    return provider;
  }

  private void init(){

    InetAddress inetAddress = getCurrentIp();
    logger.info("当前启动实例IP:{}", Objects.requireNonNull(inetAddress).getHostAddress());
    byte[] ipAddressByteArray = inetAddress.getAddress();
    long totalId = 0L;
    if (ipAddressByteArray.length == 4) {
      for (byte byteNum : ipAddressByteArray) {
        totalId += (byteNum & 0xFF);
      }
    } else if (ipAddressByteArray.length == 16) {
      for (byte byteNum : ipAddressByteArray) {
        totalId += (byteNum & 0B111111);
      }
    } else {
      throw new IllegalStateException("Bad LocalHost InetAddress, please check your network!");
    }
    logger.info("本实例数据库主键的WorkerId:{}", totalId);
    String totalStr = patchLength(Long.toBinaryString(totalId));
    logger.info("totalId:{}", totalStr);
    String dataCenterIdStr = totalStr.substring(0, 5);
    logger.info("dataCenterId二进制:{}", dataCenterIdStr);
    String workerIdStr = totalStr.substring(5);
    logger.info("workerId二进制:{}", workerIdStr);
    Integer dataCenterId = Integer.valueOf(dataCenterIdStr, 2);
    logger.info("dataCenterId:{}", dataCenterId);
    Integer workerId = Integer.valueOf(workerIdStr, 2);
    logger.info("workerId:{}", workerId);
    this.dataCenterId = Long.valueOf(dataCenterId);
    this.workId = Long.valueOf(workerId);
    logger.info("设置完毕");
  }

  private InetAddress getCurrentIp() {
    try {
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
      while (networkInterfaces.hasMoreElements()) {
        NetworkInterface ni = networkInterfaces.nextElement();
        Enumeration<InetAddress> nias = ni.getInetAddresses();
        while (nias.hasMoreElements()) {
          InetAddress ia = nias.nextElement();
          if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
            return ia;
          }
        }
      }
    } catch (SocketException e) {
      logger.error("unable to get current IP " + e.getMessage(), e);
    }
    return null;
  }

  private String patchLength(String binaryString) {
    StringBuilder sbResult = new StringBuilder();
    if (binaryString.length() < 10) {
      int diff = 10 - binaryString.length();
      for (int i = 0; i < diff; i++) {
        sbResult.append(0);
      }
    }
    return sbResult.append(binaryString).toString();
  }

  public Long generateId(){
    return getProvider().nextId();
  }
}
