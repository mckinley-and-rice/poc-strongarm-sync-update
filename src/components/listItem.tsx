/* eslint-disable react/jsx-props-no-spreading */
import React from 'react';
import { Text, View } from 'react-native';
import style from './styles';

type Props = {
  name: string;
  id: string;
}

/**
 * @function
 * Button UI
 */
const ListItem: React.FunctionComponent<Props> = (props: Props) => {
  const { name, id } = props;
  return (
    <View style={style.listItemView}>
      <Text style={style.listItemText}>{name} - {id}</Text>
    </View>
  );
};

export default ListItem;
