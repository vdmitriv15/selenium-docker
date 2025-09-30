FROM bellsoft/liberica-openjre-alpine:17.0.8

# Install curl and jq
RUN apk add curl jq

# workspace
WORKDIR /home/selenium-docker

# Add required files
ADD target/docker-resources ./
ADD runner.sh runner.sh

# Fix for windows
RUN dos2unix runner.sh

# Start the runner.sh
ENTRYPOINT sh runner.sh
