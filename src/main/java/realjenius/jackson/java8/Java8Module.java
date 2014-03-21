package realjenius.jackson.java8;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;

/**
 * <p>Module that installs Java 8 optional support into Jackson.</p>
 *
 * <p>This is very closely modeled after the support in jackson-datatype-guava for Optionals</p>
 *
 * @author R.J. Lorimer [rj@realjenius.com]
 */
public class Java8Module extends Module {

    @Override
    public String getModuleName() {
        return "java8";
    }

    @Override
    public Version version() {
        return Version.unknownVersion();
    }

    @Override
    public void setupModule(SetupContext context) {
        context.addDeserializers(new Java8Deserializers());
        context.addSerializers(new Java8Serializers());
        context.addBeanSerializerModifier(new Java8BeanSerializerModifier());
    }

}
