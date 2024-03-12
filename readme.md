# Instruction
1. Build docker image
    ```shell
    docker buildx build -t auth-service:0.0.3 .
    ```
2. Add tag to image
    ```shell
    docker tag auth-service:0.0.3 otuslearning/auth-service:0.0.3
    ```
3. Push image
    ```shell
    docker push otuslearning/auth-service:0.0.3
    ```