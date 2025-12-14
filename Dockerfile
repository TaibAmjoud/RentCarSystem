FROM openjdk:19-ea-jdk-alpine3.16
RUN addgroup app && adduser -S -G app app
USER app
WORKDIR /src
COPY . .
RUN mkdir out && javac -d out $(find . -name "*.java")
CMD ["java", "-cp", "out", "Main"]