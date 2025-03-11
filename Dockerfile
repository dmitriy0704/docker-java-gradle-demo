FROM eclipse-temurin:21-jdk as build

RUN mkdir /project
WORKDIR /project

COPY ./gradle ./gradle
COPY ./gradlew* ./settings.gradle*.
RUN ./gradlew

COPY . .

RUN ./gredlew clean installDist

FROM eclipse-temurin:21-jre

RUN mkdir /opt/app

COPY --from=build /project/build/install/docker-java-gradle-demo /opt/app/

WORKDIR /opt/app/bin

CMD ["./docker-java-gradle-demo"]