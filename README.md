Example Jersey
==============
Jersey example and executable war. (Powered by Jetty)

Synopsys (for Eclipse)
-----------
(this example is require network)

### setup

	git clone (this project)
	cd (this project directory)

### setup (if using eclipse)

	gradle cleanEclipse eclipse

### build

	# build
	gradlew war

### build executable war

	gradlew executableWar
	java -jar java -Dorg.eclipse.jetty.LEVEL=DEBUG -jar build\libs\JerseyExample-executable-0.01.war


