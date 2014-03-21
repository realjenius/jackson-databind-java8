package realjenius.jackson.java8;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.Deserializers;

import java.util.Optional;

/**
 * @author R.J. Lorimer [rj@realjenius.com]
 */
public class Java8Deserializers extends Deserializers.Base {

    @Override
    public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
        Class<?> raw = type.getRawClass();
        if(Optional.class.isAssignableFrom(raw)){
            return new Java8OptionalDeserializer(type);
        }
        return super.findBeanDeserializer(type, config, beanDesc);
    }
}