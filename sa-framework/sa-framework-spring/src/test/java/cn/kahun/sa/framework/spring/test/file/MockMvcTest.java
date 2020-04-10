package cn.kahun.sa.framework.spring.test.file;

import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cn.kahun.sa.framework.spring.file.StorageService;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @create: 2020/4/10 5:11 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private StorageService storageService;

  @Test
  public void testListAllFiles() throws Exception {

    BDDMockito.given(storageService.loadAll()).willReturn(Stream.of(Paths.get("first.txt"),Paths.get("second.txt")));

    this.mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.model().attribute("files", Matchers.contains("http://localhost/files/first.txt","http://localhost/files/second.txt")));

  }

  @Test
  public void shouldSaveUploadedFile() throws Exception {
    MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
        "text/plain", "Spring Framework".getBytes());
    this.mockMvc.perform(multipart("/").file(multipartFile))
        .andExpect(status().isFound())
        .andExpect(header().string("Location", "/"));

    then(this.storageService).should().store(multipartFile);
  }

}
