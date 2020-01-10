import com.kevin.UploadApplication;
import com.kevin.util.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = UploadApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class Test {

    @org.junit.Test
    public void test() {
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static" + UploadUtils.IMG_PATH_PREFIX;
        String os = System.getProperty("os.name");
        log.warn("path:{}, os:{}", path, os );
    }
}
