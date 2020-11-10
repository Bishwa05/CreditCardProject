package creditcard.detectcard;

import creditcard.model.CardDto;

import java.util.List;

public class XmlFileOperation implements IoOperation
{
    public List<CardDto> readFile(String fileName){
//        StaxEventItemReader<StudentDTO> xmlFileReader = new StaxEventItemReader<>();
//        xmlFileReader.setResource(new ClassPathResource("data/students.xml"));
//        xmlFileReader.setFragmentRootElementName("student");
//
//        Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
//        studentMarshaller.setClassesToBeBound(StudentDTO.class);
//        xmlFileReader.setUnmarshaller(studentMarshaller);
//
//        return xmlFileReader;
        return null;
    }

    public void writeFile(String filePath, List<String> response) throws Exception{

    }
}
