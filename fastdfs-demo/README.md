docker pull delron/fastdfs

docker network create fastdfs

docker run -dit --name tracker \
--network=fastdfs \
-p 22122:22122 -p 8888:8888 \
-v ~/DockerFiles/fdfs/tracker:/var/fdfs \
delron/fastdfs:latest tracker

docker inspect <container id>

docker run -dit --name storage0 \
--network=fastdfs \
-e TRACKER_SERVER=172.19.0.2:22122 \
-v ~/DockerFiles/fdfs/storage0:/var/fdfs \
delron/fastdfs:latest storage



docker run -dit --name storage1 \
--network=fastdfs \
-e TRACKER_SERVER=172.19.0.2:22122 \
-v ~/DockerFiles/fdfs/storage1:/var/fdfs \
delron/fastdfs:latest storage


