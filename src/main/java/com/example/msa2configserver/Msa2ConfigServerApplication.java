package com.example.msa2configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
* config server 를 구성하는 방법은 여러 가지가 존재한다.
* [1] github 에 secret repo 를 등록해서 설정 정보를 받아온다.
* [2] github submodule 을 이용한다.
* [3] 동일한 프로젝트 경로 내에 암호화해서 민감한 정보를 숨긴다.
*
* [2], [3] 은 설정 정보를 업데이트 후 서버를 재시작해야된다는 단점이 존재한다.
* 따라서 [1] 이 합리적이며 github 에 장애가 생기면 치명적이라는 단점이 존재하나
* github 가 장애가 발생하긴 하나? 생각해보면 가장 합리적인 선택이라고 생각된다.
* RSA 방식을 이용해 github 에 private key, public key 를 등록해서 정보를
* 주고받을 수 있다.
*
* 다만 여기서는 (강의목적으로) 좀 다른 방법을 사용하는데, native profile 을 이용해서
* github 에서 정보를 받아오는 것이 아닌 config-server 프로젝트 내에
* 다른 프로젝트 설정 파일을 보관하는 것이다. 어떠한 장점이 있을지 생각해보자.
*
* (1) config-server 프로젝트 내에서 관리를 할 수 있다 (github 에서 받아온다면,
* 실제 파일을 따로 관리해주어야 한다)
* (2) github 에 문제가 생겨도 영향을 덜 받는다 (프로젝트 내에 가지고 있으니까)
* */


@SpringBootApplication
@EnableConfigServer
public class Msa2ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Msa2ConfigServerApplication.class, args);
	}

}
