#!/bin/sh

echo "eth0 up......."
ifconfig eht0 up
udhcpc -i eth0

: exit 0
