package com.machinarymgmt.service.api.mapper;

import com.machinarymgmt.service.api.config.dto.ApiMessage;
import com.machinarymgmt.service.api.config.dto.BaseApiResponse;
import com.machinarymgmt.service.api.data.model.Item;
import com.machinarymgmt.service.dto.ItemDto;
import com.machinarymgmt.service.dto.ItemListResponse;
import com.machinarymgmt.service.dto.ItemRequestDto;
import com.machinarymgmt.service.dto.ItemResponse;
import com.machinarymgmt.service.dto.MachinaryMgmtBaseApiResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:53:17+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDto toDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setItemType( itemTypeToItemTypeEnum( item.getType() ) );
        itemDto.setId( item.getId() );
        itemDto.setDescription( item.getDescription() );
        itemDto.setCode( item.getCode() );
        itemDto.setUom( item.getUom() );

        return itemDto;
    }

    @Override
    public Item toEntity(ItemRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Item.ItemBuilder item = Item.builder();

        item.type( itemTypeEnumToItemType( dto.getItemType() ) );
        item.code( dto.getCode() );
        item.description( dto.getDescription() );
        item.uom( dto.getUom() );

        return item.build();
    }

    @Override
    public List<ItemDto> toDtoList(List<Item> item) {
        if ( item == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( item.size() );
        for ( Item item1 : item ) {
            list.add( toDto( item1 ) );
        }

        return list;
    }

    @Override
    public ItemListResponse toDtoList(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        ItemListResponse itemListResponse = new ItemListResponse();

        return itemListResponse;
    }

    @Override
    public MachinaryMgmtBaseApiResponse toBaseApiResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        MachinaryMgmtBaseApiResponse machinaryMgmtBaseApiResponse = new MachinaryMgmtBaseApiResponse();

        List<ApiMessage> list = baseApiResponse.getMessages();
        if ( list != null ) {
            machinaryMgmtBaseApiResponse.messages( new ArrayList<ApiMessage>( list ) );
        }
        machinaryMgmtBaseApiResponse.metadata( baseApiResponse.getMetadata() );
        machinaryMgmtBaseApiResponse.respType( baseApiResponse.getRespType() );
        machinaryMgmtBaseApiResponse.status( baseApiResponse.getStatus() );

        return machinaryMgmtBaseApiResponse;
    }

    @Override
    public ItemResponse toItemApiResponse(BaseApiResponse baseApiResponse) {
        if ( baseApiResponse == null ) {
            return null;
        }

        ItemResponse itemResponse = new ItemResponse();

        return itemResponse;
    }

    @Override
    public void updateEntityFromDto(ItemRequestDto dto, Item item) {
        if ( dto == null ) {
            return;
        }

        item.setCode( dto.getCode() );
        item.setDescription( dto.getDescription() );
        item.setUom( dto.getUom() );
    }

    protected ItemDto.ItemTypeEnum itemTypeToItemTypeEnum(Item.ItemType itemType) {
        if ( itemType == null ) {
            return null;
        }

        ItemDto.ItemTypeEnum itemTypeEnum;

        switch ( itemType ) {
            case MATERIAL: itemTypeEnum = ItemDto.ItemTypeEnum.MATERIAL;
            break;
            case SPARE: itemTypeEnum = ItemDto.ItemTypeEnum.SPARE;
            break;
            case OTHER: itemTypeEnum = ItemDto.ItemTypeEnum.OTHER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + itemType );
        }

        return itemTypeEnum;
    }

    protected Item.ItemType itemTypeEnumToItemType(ItemRequestDto.ItemTypeEnum itemTypeEnum) {
        if ( itemTypeEnum == null ) {
            return null;
        }

        Item.ItemType itemType;

        switch ( itemTypeEnum ) {
            case MATERIAL: itemType = Item.ItemType.MATERIAL;
            break;
            case SPARE: itemType = Item.ItemType.SPARE;
            break;
            case OTHER: itemType = Item.ItemType.OTHER;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + itemTypeEnum );
        }

        return itemType;
    }
}
