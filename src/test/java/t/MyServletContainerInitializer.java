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
 * javax.servlet.ServletContainerInitializer�ļ�����·����spring-framework/spring-web/src/main/resources/META-INF/services/�£�

���ļ��ļ������ǡ�javax.servlet.ServletContainerInitializer����������ֻ����������

 

org.springframework.web.SpringServletContainerInitializer
 

���ˣ���ش���/�ļ���������������ˡ�

       ��ô�뿴SpringServletContainerInitializer�࣬��ʵ���� Servlet ��ServletContainerInitializer�ӿڣ�������"@HandlesTypes(WebApplicationInitializer.class) "ע�⣬���ע��ָ����ServletContainerInitializer�ӿڿ���ʹ�õ��ࡣ

     ���ұ����� spring-web-X.X.X.RELEASE-sources.jar �ļ��£���META_INF/services·�����и���Ϊ�� javax.servlet.ServletContainerInitializer�����ļ����ļ��е������� ServletContainerIntializer��ʵ����ȫ�޶�����ͬ(��ο����������Ĵ���)��������webӦ������ʱ������ͻ��ҵ�WebApplicationInitializer����ӿڵ�ʵ���࣬������onStartup������

���˵�ò��Եĵط�����ָ����лл
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
