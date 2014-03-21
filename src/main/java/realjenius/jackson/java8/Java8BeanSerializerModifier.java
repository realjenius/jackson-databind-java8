package realjenius.jackson.java8;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author R.J. Lorimer [rj@realjenius.com]
 */
public class Java8BeanSerializerModifier extends BeanSerializerModifier {
    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        return beanProperties.stream().map((w) -> {
            BeanPropertyWriter mapping = w;
            if (Optional.class.isAssignableFrom(w.getPropertyType())) {
                mapping = new Java8OptionalBeanPropertyWriter(w);
            }
            return mapping;
        }).collect(Collectors.toList());
    }
}
