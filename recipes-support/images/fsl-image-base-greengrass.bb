DESCRIPTION = "Greengrass Image"
LICENSE = "MIT"

require recipes-fsl/images/fsl-image-base.bb

IMAGE_INSTALL_append = " openjdk-8"
IMAGE_INSTALL_append = " greengrass"
IMAGE_INSTALL_append = " python"
IMAGE_INSTALL_append = " python3"
IMAGE_INSTALL_append = " bash"
IMAGE_INSTALL_append = " nodejs"
IMAGE_INSTALL_append = " nxp-networking"
IMAGE_INSTALL_append = " os-release"

IMAGE_NAME = "${MACHINE}-greengrass"
IMAGE_LINK_NAME = "${MACHINE}-${IMAGE_BASENAME}"

