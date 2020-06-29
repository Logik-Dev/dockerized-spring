#!/bin/bash

if [ ! -z $(docker ps -aq) ]; then
	docker rm --force $(docker ps -aq)
fi

