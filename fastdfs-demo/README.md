docker run -dit --name tracker \
-p 22122:22122 \
-v /Users/tioachan/DockerFiles/fdfs/tracker:/var/fdfs \
ygqygq2/fastdfs-nginx:latest tracker



docker run -dit --name storage0 \
-e TRACKER_SERVER=172.17.0.1:22122 \
-v /Users/tioachan/DockerFiles/fdfs/storage0:/var/fdfs \
ygqygq2/fastdfs-nginx:latest storage



docker run -dit --name storage1 \
-e TRACKER_SERVER=172.17.0.1:22122 \
-v /Users/tioachan/DockerFiles/fdfs/storage1:/var/fdfs \
ygqygq2/fastdfs-nginx:latest storage