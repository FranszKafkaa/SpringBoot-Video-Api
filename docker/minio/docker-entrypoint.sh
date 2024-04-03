#!/bin/sh

# Start MinIO server
minio server /data/minio --console-address ":8900" &

# Wait for MinIO server to start
sleep 1
# Create a bucket
mc alias set sail http://localhost:9000 sail password
mc mb sail/main

# Keep the script running
wait
