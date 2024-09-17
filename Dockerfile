FROM ubuntu:latest
LABEL authors="Pavcore"

ENTRYPOINT ["top", "-b"]