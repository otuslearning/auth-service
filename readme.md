# Instruction
1. Build docker image
    ```shell
    docker buildx build -t auth-service:0.0.1 .
    ```
2. Add tag to image
    ```shell
    docker tag auth-service:0.0.1 otuslearning/auth-service:0.0.1
    ```
3. Push image
    ```shell
    docker push otuslearning/auth-service:0.0.1
    ```