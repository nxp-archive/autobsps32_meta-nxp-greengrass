DESCRIPTION = "Greengrass Image"
LICENSE = "MIT"

require recipes-support/images/fsl-image-greengrass.inc
require recipes-fsl/images/fsl-image-auto.bb

IMAGE_NAME = "${MACHINE}-greengrass"
IMAGE_LINK_NAME = "${MACHINE}-${IMAGE_BASENAME}"

