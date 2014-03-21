package realjenius.jackson.java8;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Optional;

/**
 * @author R.J. Lorimer [rj@realjenius.com]
 */
public class Java8OptionalSerializer extends StdSerializer<Optional<?>> {

    public Java8OptionalSerializer(JavaType type) {
        super(type);
    }
    @Override
    public void serialize(Optional<?> value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if(value.isPresent()) {
            provider.defaultSerializeValue(value.get(), jgen);
        } else {
            provider.defaultSerializeNull(jgen);
        }
    }
}
