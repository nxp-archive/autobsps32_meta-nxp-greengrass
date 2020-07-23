# meta-nxp-greengrass

The meta-nxp-greengrass layer provides the recipes along with meta-java and meta-aws to create an image with Greengrass support on the S32G devices. 

### Initialize and sync repo

These steps work for nxp internal network. Make sure you have the correct ssh keys in bitbucket. 

https://confluence.atlassian.com/bitbucketserver068/creating-ssh-keys-981145250.html

https://confluence.atlassian.com/bitbucketserver068/ssh-user-keys-for-personal-use-981145255.html

```shell
mkdir <yocto_dir>
cd <yocto_dir>
repo init -u ssh://git@bitbucket.sw.nxp.com/~nxa11750/meta-nxp-greengrass.git -m manifests/greengrass.xml
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

