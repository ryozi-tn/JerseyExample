Example Jersey
==============
Jersey example and executable war. (Powered by Jetty)

Synopsys (for Eclipse)
-----------
(this example is require network)

### setup

	git clone https://github.com/ryozi-tn/JerseyExample
	cd JerseyExample

### setup (if using eclipse)

	./gradlew cleanEclipse eclipse

### build

	./gradlew war

### build executable war

	./gradlew executableWar
	java -Dorg.eclipse.jetty.LEVEL=DEBUG -jar build\libs\JerseyExample-executable-0.01.war


