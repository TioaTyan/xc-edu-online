## nginx

> https://www.cnblogs.com/saneri/p/11799865.html

```shell script
docker pull nginx
```

```
docker run --name nginx1 \
-p 80:80 -p 443:443 \
-v ~/DockerFiles/nginx1/nginx.conf:/etc/nginx/nginx.conf \
-v ~/DockerFiles/nginx1/cert.pem:/etc/nginx/cert.pem \
-v ~/DockerFiles/nginx1/fullchain.pem:/etc/nginx/fullchain.pem \
-v ~/DockerFiles/nginx1/tioachan.dev.key:/etc/nginx/tioachan.dev.key \
-v /Volumes/SWAP/xc-ui-pc-static-portal:/usr/share/nginx/html \
-d nginx
```