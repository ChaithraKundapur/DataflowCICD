# Dockerizing a base images with:
#
#   - Ubuntu 20.04 LTS (Focal Fossa)
#   - OpenJDK 11
#
# Build:    docker build -t exoplatform/jdk:openjdk-11 .
#
# Run:      docker run -ti exoplatform/jdk:openjdk-11 -version


FROM maven
RUN mkdir /app
WORKDIR /app
COPY . /app
RUN mvn clean install
CMD "mvn" "exec:java"