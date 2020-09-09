/* eslint-disable react/jsx-props-no-spreading */
import React, { useEffect, useState } from 'react';
import { TouchableOpacity, Text, TouchableOpacityProperties, View, NativeModules, Alert } from 'react-native';
import ListItem from './listItem';
import ButtonStyle from './styles';

const { AthleteModule } = NativeModules

type Props = {
  buttonText?: string;
} & TouchableOpacityProperties;

/**
 * @function
 * Button UI
 */
const ListView: React.FunctionComponent<Props> = (props: Props) => {
	const [ data, setData]: [any, any] = useState([]);
	useEffect(() => {
		AthleteModule.getAthletes()
		.then((athletes: any) => {
			setData(athletes);
			alert('loaded from local');
			return AthleteModule.loadFromServer()
		})
		.then(loaded => {
			alert('loaded from server');
		});
	}, [])
  const { buttonText } = props;

  let renderFields = () => {
    const fields = [];
    for (let i = 0; i < data.length; i++) {
      // Try avoiding the use of index as a key, it has to be unique!
      fields.push(
        <ListItem key={data[i].id} id={data[i].id} name={data[i].first_name} />
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
