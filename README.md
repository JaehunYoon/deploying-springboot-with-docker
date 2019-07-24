# deploying-springboot-with-docker

Learn about how to deploy **Spring Boot Application** with docker.

## Dependency Injection

```kotlin
plugins {
	...
	id("com.google.cloud.tools.jib") version "1.0.0"
	// jib 플러그인을 사용하기 위해 build.gradle - plugins 에 의존성 주입
}
```

Then.. **[What is JIB?](https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin)**

## Create WAR File

```
$ ./gradlew bootWar
```

WAR 파일을 생성하기 위한 명령어

입력 후 실행 시 build/libs 경로에 WAR 스냅샷 파일이 생성되는 것을 볼 수 있다.

## Create Docker Image

**Docker는 사전에 설치가 되어있어야 합니다!**

```
$ ./gradlew jibDockerBuild
```

**jib** 플러그인을 추가한 후 다음 명령어를 입력하여 실행하게 되면, Docker Image 를 생성합니다.

```
$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
docker              0.0.1-SNAPSHOT      bfff6d4e39b9        49 years ago        172MB
```

Docker Image 가 정상적으로 생성된 것을 확인할 수 있습니다.

## Run Spring Boot Application with Docker

```
$ docker run -d -p 80:8080 --name [Container Name] [Image]
```

생성된 Docker Image를 통해 컨테이너를 올립니다.

`docker run`의 **-d** 옵션은 --detach (Run container in background and print container ID) 를 의미하고, **-p** 옵션은 --publish list (Publish a container's port(s) to the host) 를 의미합니다.

```
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                  NAMES
b16f1a358d7f        bfff6d4e39b9        "/usr/bin/java -jar …"   About an hour ago   Up About an hour    0.0.0.0:80->8080/tcp   my-demo
```

Docker Container 가 정상적으로 올라간 것을 볼 수 있습니다.

위 컨테이너에서 정상적으로 사전에 만들었던 Spring Boot Application 이 동작하는 지 확인하기 위해 `localhost/hello/Jaehun` 으로 접속을 해봅시다.

**Hello, Jaehun** 이 브라우저에 나타나면, 정상적으로 Spring Boot Application 을 Docker Image 로 생성하여 Container 에 올린 것을 확인할 수 있습니다. 