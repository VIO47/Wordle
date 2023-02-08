package Client;

import com.google.inject.Injector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Builder;
import javafx.util.BuilderFactory;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class MyFXML {

    private Injector injector;

    public MyFXML(Injector injector) {
        this.injector = injector;
    }

    public <T> Pair<T, Parent> load(Class<T> c, String... parts) throws RuntimeException {
        try {
            var loader =
                new FXMLLoader(getLocation(parts), null, null, new MyFactory(), StandardCharsets.UTF_8);
            Parent parent = loader.load();
            T ctrl = loader.getController();
            return new Pair<>(ctrl, parent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private URL getLocation(String[] parts) {
        var path = Path.of("", parts).toString();
        return MyFXML.class.getClassLoader().getResource(path);

    }

    private class MyFactory implements BuilderFactory, Callback<Class<?>, Object> {

        /**
         * {@inheritDoc}
         */
        @Override
        @SuppressWarnings("rawtypes")
        public Builder<?> getBuilder(Class<?> type) {
            return new Builder() {

                /**
                 * Returns a new instance of the specified type.
                 *
                 * @return a new instance of the specified type
                 */
                @Override
                public Object build() {
                    return injector.getInstance(type);
                }
            };
        }

        /**
         * Returns a new instance of the specified type.
         *
         * @param type the type of the class to get a new instance from
         * @return a new instance of the specified type
         */
        @Override
        public Object call(Class<?> type) {
            return injector.getInstance(type);
        }
    }

}
