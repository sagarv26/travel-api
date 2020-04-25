package binding;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import services.DistrictService;
import services.PlaceService;
import services.impl.DistrictServiceImpl;
import services.impl.PlaceServiceImpl;

/**
 * Created by shreyas.hande on 12/10/17.
 */
public class ServiceModule extends AbstractModule {
	protected void configure() {
		bind(DistrictService.class).to(DistrictServiceImpl.class).in(Scopes.SINGLETON);
		bind(PlaceService.class).to(PlaceServiceImpl.class).in(Scopes.SINGLETON);
	}
}
