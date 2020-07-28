/* eslint-disable react/jsx-props-no-spreading */
import React from 'react';
import { TouchableOpacity, Text, TouchableOpacityProperties, View } from 'react-native';
import ListItem from './listItem';
import ButtonStyle from './styles';

type Props = {
  buttonText?: string;
} & TouchableOpacityProperties;

/**
 * @function
 * Button UI
 */
const ListView: React.FunctionComponent<Props> = (props: Props) => {
  const { buttonText } = props;

  let data = [
    {
      name: 'Kumar Gaurav',
      id: 'SE1'
    },
    {
      name: 'Shrey Gupta',
      id: 'SE51'
    },
    {
      name: 'Karan',
      id: 'DR4'
    },
    {
      name: 'Anand Rai',
      id: 'PL10'
    }
  ];

  let renderFields = () => {
    const fields = [];
    for (let i = 0; i < data.length; i++) {
      // Try avoiding the use of index as a key, it has to be unique!
      fields.push(
        <ListItem key={data[i].id} id={data[i].id} name={data[i].name} />
      );
    }
    return fields;
  }

  return (
    <View>
      {renderFields()}
    </View>
  );
};

export default ListView;
