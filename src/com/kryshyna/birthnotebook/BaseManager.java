package com.kryshyna.birthnotebook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Vadym Kryshyna
 * Date: 30.09.14
 * Time: 14:25
 */

public class BaseManager {
    private static String fileName = "base.xml";

    public static People readBase() throws JAXBException {
        People people;
        File file = new File(fileName);
        if(file.exists()){
            JAXBContext context = JAXBContext.newInstance(People.class);
            Unmarshaller unmarshaller =  context.createUnmarshaller();
            people = (People)unmarshaller.unmarshal(file);
        } else {
            people = new People();
        }
        return people;
    }

    public static void saveBase(People people) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(People.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(people, new File(fileName));
    }
}
