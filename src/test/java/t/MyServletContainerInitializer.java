package t;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.WebApplicationInitializer;
/**
 * 
 * javax.servlet.ServletContainerInitializer文件（在路径：spring-framework/spring-web/src/main/resources/META-INF/services/下）

该文件文件名就是“javax.servlet.ServletContainerInitializer”，其内容只有下面这行

 

org.springframework.web.SpringServletContainerInitializer
 

至此，相关代码/文件，都在上面给出了。

       那么请看SpringServletContainerInitializer类，它实现了 Servlet 的ServletContainerInitializer接口，并且有"@HandlesTypes(WebApplicationInitializer.class) "注解，这个注解指明了ServletContainerInitializer接口可以使用的类。

     并且必须在 spring-web-X.X.X.RELEASE-sources.jar 文件下，的META_INF/services路径下有个名为“ javax.servlet.ServletContainerInitializer”的文件，文件中的内容与 ServletContainerIntializer的实现类全限定名相同(请参考上面贴出的代码)。这样，web应用启动时，程序就会找到WebApplicationInitializer这个接口的实现类，并调用onStartup方法。

如果说得不对的地方，请指正，谢谢
 *
 */
@HandlesTypes(WebApplicationInitializer.class)
public class MyServletContainerInitializer implements
		ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> webAppInitializerClasses,
			ServletContext servletContext) throws ServletException {
		List<WebApplicationInitializer> initializers = new LinkedList<WebApplicationInitializer>();

		if (webAppInitializerClasses != null) {
			for (Class<?> waiClass : webAppInitializerClasses) {
				// Be defensive: Some servlet containers provide us with invalid classes,
				// no matter what @HandlesTypes says...
				if (!waiClass.isInterface()
						&& !Modifier.isAbstract(waiClass.getModifiers())
						&& WebApplicationInitializer.class
								.isAssignableFrom(waiClass)) {
					try {
						initializers.add((WebApplicationInitializer) waiClass
								.newInstance());
					} catch (Throwable ex) {
						throw new ServletException(
								"Failed to instantiate WebApplicationInitializer class",
								ex);
					}
				}
			}
		}

		if (initializers.isEmpty()) {
			servletContext
					.log("No Spring WebApplicationInitializer types detected on classpath");
			return;
		}

		AnnotationAwareOrderComparator.sort(initializers);
		servletContext
				.log("Spring WebApplicationInitializers detected on classpath: "
						+ initializers);

		for (WebApplicationInitializer initializer : initializers) {
			initializer.onStartup(servletContext);
		}
	}

}
