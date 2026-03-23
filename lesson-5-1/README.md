```shell
docker run --rm --name mynginx -v $(pwd)/my_ngnix.conf:/etc/nginx/nginx.conf:ro -d -p 222:222 nginx
```