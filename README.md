# SpringMVC 学习项目说明

## 项目是做什么的

这是一个按 `day01 ~ day05` 递进的 SpringMVC 教学/练习项目集合，目标是通过多个小型 Web 工程，覆盖 SpringMVC 从入门到进阶的常见能力：

- 基础请求映射与控制器开发
- 请求参数绑定与 REST 风格路径
- 作用域数据共享、视图解析、转发/重定向
- 请求体/响应体处理、JSON、文件上传下载
- 拦截器、异常处理、全注解配置（替代 `web.xml` + `springMVC.xml`）

项目同时包含一份较完整的学习笔记：`笔记/SpringMVC笔记.md`。

---

## 仓库结构

```text
springmvc/
├─ 代码/
│  ├─ day01/
│  │  └─ springMVC-demo1/
│  ├─ day02/
│  │  └─ springMVC-demo2/
│  ├─ day03/
│  │  ├─ springMVC-demo3/
│  │  └─ springMVC-jsp/
│  ├─ day04/
│  │  ├─ springMVC-demo4/
│  │  └─ springMVC-rest/
│  └─ day05/
│     ├─ springMVC-demo5/
│     └─ springMVC-annotation/
├─ 笔记/
│  ├─ SpringMVC笔记.md
│  ├─ SpringMVC笔记.pdf
│  └─ img/
└─ README.md
```

> 各模块下的 `target/` 为构建产物目录，不是核心源码。

---

## 各模块内容（按学习顺序）

| Day | 模块 | 重点内容 | 关键类/文件 |
|---|---|---|---|
| day01 | `springMVC-demo1` | HelloWorld、`@RequestMapping` 基础映射、Thymeleaf 视图解析 | `HelloController`、`springMVC.xml`、`web.xml` |
| day02 | `springMVC-demo2` | 请求映射细节（method/params/headers/Ant/PathVariable）、参数绑定（`@RequestParam`/`@RequestHeader`/`@CookieValue`/POJO） | `RequestMappingController`、`ParamController` |
| day03 | `springMVC-demo3` | 域对象共享（request/session/application）、`ModelAndView`/`Model`/`Map`、转发与重定向、REST 风格基础 | `ScopeController`、`ViewController`、`UserController` |
| day03 | `springMVC-jsp` | JSP 视图解析器（`InternalResourceViewResolver`）示例 | `JspController`、`springMVC.xml` |
| day04 | `springMVC-demo4` | `@RequestBody`、`RequestEntity`、`@ResponseBody`、JSON 响应、Axios、文件上传下载（`MultipartFile`、`ResponseEntity`） | `HttpController`、`FileUpAndDownController` |
| day04 | `springMVC-rest` | 完整的员工 CRUD（REST 风格 + Thymeleaf 页面） | `EmployeeController`、`EmployeeDao` |
| day05 | `springMVC-demo5` | 拦截器执行流程、统一异常处理（`@ControllerAdvice` + `@ExceptionHandler`） | `FirstInterceptor`、`SecondInterceptor`、`ExceptionController` |
| day05 | `springMVC-annotation` | 全注解配置：Java Config + `WebInit` 取代 XML | `WebInit`、`WebConfig`、`SpringConfig` |

---

## 技术栈与版本特征

从各模块 `pom.xml` 可见：

- 构建方式：Maven，多模块均为 `war` 打包
- 视图层：Thymeleaf（`day03/springMVC-jsp` 使用 JSP）
- 主体版本：大部分模块使用 Spring 5.3.1 + `javax.servlet`
- 特殊点：`day01/springMVC-demo1` 使用 Spring 6.1.8 + `jakarta.servlet`（JDK 17）

> 因此本仓库中存在 `javax.*` 与 `jakarta.*` 的并存，这是示例演进带来的正常现象。

---

## 如何运行（通用）

每个子工程是独立 Web 应用，可单独运行。

1. 在 IDEA 中按模块导入 Maven 工程（例如 `代码/day04/springMVC-rest`）。
2. 执行 Maven 打包（生成 WAR）。
3. 部署到本地 Tomcat，设置对应上下文路径。
4. 启动后访问模块首页（通常是 `/<context-path>/`）。

示例（在某个模块目录执行）：

```bat
mvn clean package
```

如果你使用 IDEA 直接运行 Tomcat，也可以跳过手动部署 WAR 的步骤，直接将模块作为 Artifact 部署。

---

## 推荐阅读路径

建议按以下顺序看代码与笔记：

1. `day01 -> day02`：先掌握请求映射与参数绑定
2. `day03`：理解视图与作用域数据共享
3. `day04`：重点练习前后端交互与文件处理
4. `day05`：掌握拦截器、异常处理、注解配置
5. 对照 `笔记/SpringMVC笔记.md` 做知识回顾

---

## 快速定位入口文件

- XML 配置项目入口：`src/main/webapp/WEB-INF/web.xml` + `src/main/resources/springMVC.xml`
- 注解配置项目入口：`day05/springMVC-annotation/src/main/java/com/atguigu/mvc/config/WebInit.java`
- 控制器包路径：`src/main/java/.../controller`

---

## 说明

本仓库偏向教学演示，模块之间不是一个可直接整体启动的单体应用，而是多个可独立运行的案例工程。