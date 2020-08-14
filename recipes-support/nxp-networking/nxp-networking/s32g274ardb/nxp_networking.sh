#!/bin/sh

echo "pfe2 up......."
ifconfig pfe2 up
udhcpc -i pfe2

: exit 0
