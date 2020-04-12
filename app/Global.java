import binding.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings
{
    private Injector injector;

    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return injector.getInstance(controllerClass);
    }

    @Override
    public void onStart(Application application)
    {
        injector = Guice.createInjector(new ServiceModule());
    }
}
