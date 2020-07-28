/* eslint-disable react/jsx-props-no-spreading */
import React from 'react';
import { TouchableOpacity, Text, TouchableOpacityProperties } from 'react-native';
import ButtonStyle from './styles';

type Props = {
	buttonText: string;
} & TouchableOpacityProperties;

/**
 * @function
 * Button UI
 */
const Button: React.FunctionComponent<Props> = (props: Props) => {
	const { buttonText, style } = props;
	return (
		<TouchableOpacity testID="test" {...props} style={[ButtonStyle.customButton, style]}>
			<Text style={[ButtonStyle.customButtonText]} testID="btnText">
				{buttonText}
			</Text>
		</TouchableOpacity>
	);
};

export default Button;
