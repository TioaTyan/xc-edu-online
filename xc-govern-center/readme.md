## eureka高可用

```bash
-Dport=50101 -Deureka_server=http://127.0.0.1:50102/eureka,http://127.0.0.1:50103/eureka
```

```bash
-Dport=50102 -Deureka_server=http://127.0.0.1:50101/eureka,http://127.0.0.1:50103/eureka
```

```bash
-Dport=50103 -Deureka_server=http://127.0.0.1:50102/eureka,http://127.0.0.1:50103/eureka
```