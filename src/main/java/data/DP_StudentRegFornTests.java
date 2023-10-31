package data;

import models.StudentDTOLombok;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DP_StudentRegFornTests {

    @DataProvider
    public Iterator<Object[]> dp_StudentRegFormPositiveTest() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File("src/test/resources/data_studentForm.csv")));
        String line = bufferedReader.readLine();
        while (line != null){
            String [] split = line.split(",");
            list.add(new Object[]{StudentDTOLombok.builder()
                    .firstName(split[0])
                    .lastName(split[1])
                    .email(split[2])
                    .gender(split[3])
                    .mobile(split[4])
                    .dateOfB(split[5])
                    .subject(split[6])
                    .hobbies(split[7])
                    .address(split[8])
                    .state(split[9])
                    .city(split[10])
                    .build()});
            line = bufferedReader.readLine();
        }

        return list.iterator();
    }

}
