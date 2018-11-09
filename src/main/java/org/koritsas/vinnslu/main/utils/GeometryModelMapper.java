package org.koritsas.vinnslu.main.utils;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GeometryModelMapper extends ModelMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public GeometryModelMapper(){

        //this.addConverter(encryptionConverter());

       // this.addMappings(userPropertyMap);



/*
        this.getTypeMap(UserDTO.class,User.class).implicitMappings().addMappings(
                mapping -> mapping.using(encryptionConverter()).map(UserDTO::getPassword,User::setPassword)
        );

*/

    }

/*
    private Converter<String, String> encryptionConverter() {


        Converter<String, String> passwordConverter = ctx -> ctx.getSource() == null ? null : passwordEncoder.encode(ctx.getSource());

        return passwordConverter;
    }

    private PropertyMap<UserDTO, User> userPropertyMap = new PropertyMap<UserDTO, User>() {
        @Override
        protected void configure() {
            using(encryptionConverter()).map(source.getPassword()).setPassword(null);

        }
    };
*/
}