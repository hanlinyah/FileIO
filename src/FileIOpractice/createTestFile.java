package FileIOpractice;

import java.io.File;
import java.io.IOException;

public class createTestFile {
    public static void makefile(){
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                new File("D:/test/dir"+i+"/sub"+j).mkdirs();
                for(int k=1;k<5;k++){
                    try {
                        new File("D:/test/dir"+i+"/sub"+j+"/testfile"+i+j+k+".txt").createNewFile();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }


            }
        }

    }
}
