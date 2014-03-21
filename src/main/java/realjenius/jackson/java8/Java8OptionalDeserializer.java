package realjenius.jackson.java8;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Optional;

/**
 * @author R.J. Lorimer [rj@realjenius.com]
 */
public class Java8OptionalDeserializer extends StdDeserializer<Optional<?>> {
    private final JavaType _referenceType;

    public Java8OptionalDeserializer(JavaType valueType) {
        super(valueType);
        _referenceType = valueType.containedType(0);
    }

    @Override
    public Optional<?> getNullValue() {
        return Optional.empty();
    }

    @Override
    public Optional<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Object reference = ctxt.findRootValueDeserializer(_referenceType).deserialize(jp, ctxt);
        return Optional.of(reference);
    }
}
