package Client;

import Client.Scenes.*;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

public class MyModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(EntryCtrl.class).in(Scopes.SINGLETON);
        binder.bind(MainCtrl.class).in(Scopes.SINGLETON);
        binder.bind(InstructionsCtrl.class).in(Scopes.SINGLETON);
        binder.bind(NameCtrl.class).in(Scopes.SINGLETON);
    }
}
