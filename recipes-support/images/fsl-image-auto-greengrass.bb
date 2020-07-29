#
# Copyright 2020 NXP
#

DESCRIPTION = "Greengrass Image"
LICENSE = "MIT"

require recipes-fsl/images/fsl-image-auto.bb
require recipes-support/images/fsl-image-greengrass.inc

IMAGE_NAME = "${MACHINE}-greengrass"
IMAGE_LINK_NAME = "${MACHINE}-${IMAGE_BASENAME}"

