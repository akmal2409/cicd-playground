FROM bellsoft/liberica-openjdk-alpine:19.0.2 as build

ARG JAR_FILE=target/*.jar

COPY $JAR_FILE app.jar

RUN ["java", "-Djarmode=layertools", "-jar", "app.jar", "extract"]

FROM bellsoft/liberica-openjre-alpine:19.0.2 as launch

WORKDIR app

COPY --from=build spring-boot-loader ./
COPY --from=build snapshot-dependencies ./
COPY --from=build dependencies ./
COPY --from=build application ./


ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
