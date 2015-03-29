#!/bin/sh
rm ../_dist/felix-framework/bundle/ru.sasik.*
find . | egrep "ru.sasik.*.jar" | xargs cp -t ../_dist/felix-framework/bundle/
#java -jar ../_dist/felix-framework/bin/felix.jar

exit 0


