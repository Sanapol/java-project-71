clean:
	make -C app clean

build:
	make -C app clean build

install:
	make -C app clean install

run-dist:
	./app/build/install/app/bin/app

run:
	make -C app run

test:
	make -C app test

report:
	make -C app jacocoTestReport

lint:
	make -C app lint

update-deps:
	make -C app useLatestVersions