package com.future.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.future.basic.framework.configuration.EnableFutureBasic;
import com.future.basic.framework.mapper.TsUserMapper;
import com.future.basic.framework.model.TsUserInfoModel;
import com.future.basic.orm.mutiltenant.FutureThreadLocal;

@EnableFutureBasic
@SpringBootApplication
public class FutureBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutureBootApplication.class, args);
	}

	@RestController
	static class Conttoller {

		@Autowired
		private TsUserMapper mapper;

		@GetMapping("/ss")
		public void show() {
			Thread t1 = new Thread(() -> {
				for (int i = 1; i < 11; i++) {
					if (i % 2 == 0) {
						FutureThreadLocal.setMutiTenantLocalMark("UUID=1");
						List<TsUserInfoModel> user = mapper.queryUserInfoByAccountOrEmail();
						System.out.println("UUID=1" + "/" + user.size());
					} else {
						FutureThreadLocal.setMutiTenantLocalMark("UUID=2");
						List<TsUserInfoModel> user = mapper.queryUserInfoByAccountOrEmail();
						System.out.println("UUID=2" + "/" + user.size());
					}
				}

			});
			t1.start();
		}

		@GetMapping("/ss2")
		public void show2() {
			FutureThreadLocal.setMutiTenantLocalMark("UUID=2");
			mapper.queryUserInfoByAccountOrEmail();
		}
	}

}
