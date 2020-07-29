# meta-nxp-greengrass

The meta-nxp-greengrass layer provides the recipes along with meta-java and meta-aws to create an image with Greengrass support on the S32G devices. 

```shell
mkdir <yocto_dir>
cd <yocto_dir>
repo init -u <this repo>
repo sync
```

### Configure the build

Configure your machine and add the extra layers. 

```shell
source nxp-setup-alb.sh -m s32g274aevb -b build_greengrass -e "meta-aws meta-java meta-nxp-greengrass"
```

### Build the image

The layer provides an extra image with Greengrass support. 

```shell
bitbake -f fsl-image-base-greengrass
```

